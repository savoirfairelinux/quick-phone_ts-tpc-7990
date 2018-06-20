FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

SRC_URI_append = " file://20-dhcp.network \
                   file://usr-share-quick-phone-assets.mount \
                 "

do_install_append() {
        install -d ${D}${sysconfdir}/systemd/network
        install -m 0644 ${WORKDIR}/20-dhcp.network ${D}${sysconfdir}/systemd/network/

        install -d ${D}${datadir}/quick-phone/assets
        install -d ${D}${systemd_system_unitdir}
        install -m 0644 ${WORKDIR}/usr-share-quick-phone-assets.mount \
                        ${D}${systemd_system_unitdir}/usr-share-quick\\x2dphone-assets.mount
}

FILES_${PN} += "${datadir}/quick-phone/assets"
SYSTEMD_SERVICE_${PN} = "usr-share-quick\x2dphone-assets.mount"
