DESCRIPTION = "quick-phone application"
LICENSE = "GPL"
LIC_FILES_CHKSUM = "file://LICENSE;md5=84dcc94da3adb52b53ae4fa38fe49e5d"

PR = "r0"

SRC_URI = "git://github.com/savoirfairelinux/quick-phone.git"
SRCREV = "5e633327fb89f04002d573c5c94b030b499d3b9d"

S = "${WORKDIR}/git"

DEPENDS = "qtdeclarative qtgraphicaleffects pjsip python-argparse"
RDEPENDS_${PN} = "qtdeclarative-qmlplugins qtgraphicaleffects-qmlplugins alsa-utils pjsip python-argparse"

require recipes-qt/qt5/qt5.inc

do_install() {
       install -d ${D}${datadir}/${P}
       install -m 0755 ${B}/quickPhone ${D}${datadir}/${P}
       cp -a  ${S}/content ${D}${datadir}/${P}
       cp -a  ${S}/img ${D}${datadir}/${P}
       cp -a  ${S}/pictures ${D}${datadir}/${P}
       cp -a  ${S}/userList.json ${D}${datadir}/${P}
       install -m 0644 ${S}/quickPhone.qml ${D}${datadir}/${P}
       install -m 0644 ${S}/app.js ${D}${datadir}/${P}
       install -m 0644 ${S}/ringing.wav ${D}${datadir}/${P}
       install -m 0644 ${S}/ts_7990_config.ini ${D}${datadir}/${P}
       install -m 0755 ${S}/caller.py ${D}${datadir}/${P}

       install -d ${D}${bindir}
       echo "#!/bin/sh" > ${D}${bindir}/quickPhone
       echo "export QML_IMPORT_PATH=${datadir}/${P}" >> ${D}${bindir}/quickPhone
       echo "export QML2_IMPORT_PATH=${datadir}/${P}" >> ${D}${bindir}/quickPhone
       echo "cd ${datadir}/${P} && ./quickPhone \$* " >> ${D}${bindir}/quickPhone
       chmod +x ${D}${bindir}/quickPhone
}

FILES_${PN} += "${datadir}/${P}/*"
FILES_${PN}-dbg += "${datadir}/${P}/.debug/*"
