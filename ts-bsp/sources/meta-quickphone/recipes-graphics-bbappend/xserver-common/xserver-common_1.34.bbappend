SUMMARY = "Common X11 scripts and support files: replacement recipe"

do_install_append() {
	rm -f ${D}/${sysconfdir}/X11/Xsession.d/*
	cat <<EOF > ${WORKDIR}/00xDoorbellApp.sh
#!/bin/sh

exec quickPhone -geometry 1024x600+0+0 -nomouse
EOF
	install -m 0755 ${WORKDIR}/00xDoorbellApp.sh ${D}/${sysconfdir}/X11/Xsession.d/
}
