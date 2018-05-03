DESCRIPTION = "quick-phone application"
LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://LICENSE;md5=84dcc94da3adb52b53ae4fa38fe49e5d"

PR = "r0"

SRC_URI = "git://github.com/savoirfairelinux/quick-phone.git"
SRCREV = "5247aab3fbda166cfc4c599c54c92e9006a23e66"

SRC_URI += "\
	file://quickphone.service \
	file://quickPhone \
"

S = "${WORKDIR}/git"

DEPENDS = "qtdeclarative qtgraphicaleffects pjsip python-argparse qtmultimedia qtquick1 pjsip"
RDEPENDS_${PN} = "qtdeclarative-qmlplugins qtgraphicaleffects-qmlplugins alsa-utils pjsip-apps python-argparse"

require recipes-qt/qt5/qt5.inc

do_install() {
       install -d ${D}${datadir}/${P}
       install -m 0755 ${B}/quickPhone ${D}${datadir}/${P}
       cp -rf ${S}/content ${D}${datadir}/${P}
       cp -rf ${S}/img ${D}${datadir}/${P}
       cp -rf ${S}/pictures ${D}${datadir}/${P}
       cp -rf ${S}/userList.json ${D}${datadir}/${P}
       install -m 0644 ${S}/intro_video.mp4 ${D}${datadir}/${P}
       install -m 0644 ${S}/quickPhone.qml ${D}${datadir}/${P}
       install -m 0644 ${S}/app.js ${D}${datadir}/${P}
       install -m 0644 ${S}/ringing.wav ${D}${datadir}/${P}
       install -m 0644 ${S}/ts_7990_config.ini ${D}${datadir}/${P}
       install -m 0755 ${S}/caller.py ${D}${datadir}/${P}

       install -d ${D}${bindir}
       install -m 0755 ${WORKDIR}/quickPhone ${D}${bindir}

       install -d ${D}/${sysconfdir}/systemd/system/multi-user.target.wants
       install -m 0644 ${WORKDIR}/quickphone.service ${D}/${sysconfdir}/systemd/system/multi-user.target.wants/
}

FILES_${PN} += "${datadir}/${P}/*"
FILES_${PN}-dbg += "${datadir}/${P}/.debug/*"
