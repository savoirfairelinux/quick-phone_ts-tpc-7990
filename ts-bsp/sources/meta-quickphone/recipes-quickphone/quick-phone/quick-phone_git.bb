DESCRIPTION = "quick-phone application"
LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://LICENSE;md5=84dcc94da3adb52b53ae4fa38fe49e5d"

PR = "r1"

SRC_URI = "git://github.com/savoirfairelinux/quick-phone.git"
SRCREV = "${AUTOREV}"
PV = "1.0+git${SRCPV}"

SRC_URI += "\
	file://quickphone.service \
	file://quickPhone \
"

S = "${WORKDIR}/git"

DEPENDS = "qtdeclarative qtgraphicaleffects pjsip python-argparse qtmultimedia qtquick1 pjsip"
RDEPENDS_${PN} = "alsa-utils \
                  qtdeclarative-qmlplugins \
                  qtgraphicaleffects-qmlplugins \
                  qtmultimedia-qmlplugins \
                  qtquickcontrols-qmlplugins \
                  qtquickcontrols2-qmlplugins \
                  pjsip-apps \
                  python-argparse"

require recipes-qt/qt5/qt5.inc

inherit systemd

do_install() {
       install -d ${D}${datadir}/${PN}
       install -m 0755 ${B}/quickPhone ${D}${datadir}/${PN}
       cp -rf ${S}/content ${D}${datadir}/${PN}
       cp -rf ${S}/img ${D}${datadir}/${PN}
       cp -rf ${S}/pictures ${D}${datadir}/${PN}
       cp -rf ${S}/userList.json ${D}${datadir}/${PN}
       install -m 0644 ${S}/intro_video.mp4 ${D}${datadir}/${PN}
       install -m 0644 ${S}/quickPhone.qml ${D}${datadir}/${PN}
       install -m 0644 ${S}/app.js ${D}${datadir}/${PN}
       install -m 0644 ${S}/ringing.wav ${D}${datadir}/${PN}
       install -m 0644 ${S}/ts_7990_config.ini ${D}${datadir}/${PN}
       install -m 0755 ${S}/caller.py ${D}${datadir}/${PN}

       install -d ${D}${bindir}
       install -m 0755 ${WORKDIR}/quickPhone ${D}${bindir}

       install -d ${D}/${systemd_system_unitdir}
       install -m 0644 ${WORKDIR}/quickphone.service ${D}/${systemd_system_unitdir}
}

FILES_${PN} += "${datadir}/${PN}/*"
FILES_${PN}-dbg += "${datadir}/${PN}/.debug/*"
SYSTEMD_SERVICE_${PN} = "quickphone.service"
