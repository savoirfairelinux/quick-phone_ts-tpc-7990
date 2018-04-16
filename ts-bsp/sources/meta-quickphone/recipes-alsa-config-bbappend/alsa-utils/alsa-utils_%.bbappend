SUMMARY = "alsa utils: recipe for ts-7990 speaker and microphone configuration files"

do_install_append() {
       install -d ${D}${datadir}/alsa/init
       install -m 0644 ${S}/alsactl/init/00main ${D}${datadir}/alsa/init
       install -m 0644 ${S}/alsactl/init/ca0106 ${D}${datadir}/alsa/init
}

FILES_${PN} += "${datadir}/alsa/init/00main"
FILES_${PN} += "${datadir}/alsa/init/ca0106"

