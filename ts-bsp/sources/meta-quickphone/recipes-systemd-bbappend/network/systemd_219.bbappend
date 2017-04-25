SUMMARY = "Bring up the eth interface(s) and get dhcp address"

do_install_append() {
	cat <<EOF > ${WORKDIR}/20-dhcp.network
[Match]
Name=eth*

[Network]
DHCP=yes
EOF
	install -m 0644 ${WORKDIR}/20-dhcp.network ${D}/${sysconfdir}/systemd/network/
}
