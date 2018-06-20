FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

SRC_URI_append = " file://20-dhcp.network \
                 "

do_install_append() {
        install -d ${D}${sysconfdir}/systemd/network
        install -m 0644 ${WORKDIR}/20-dhcp.network ${D}${sysconfdir}/systemd/network/
}
