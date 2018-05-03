DESCRIPTION = "PJSIP stack"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

PR = "r0"

DEPENDS = "alsa-lib util-linux python-dev"

inherit autotools pythonnative

SRC_URI = "http://www.pjsip.org/release/${PV}/pjproject-${PV}.tar.bz2"

SRC_URI[md5sum] = "c347a672679e7875ce572e18517884b2"
SRC_URI[sha256sum] = "2f5a1da1c174d845871c758bd80fbb580fca7799d3cfaa0d3c4e082b5161c7b4"

S = "${WORKDIR}/pjproject-${PV}/"
B = "${S}"

EXTRA_OECONF = "\
    LD='${CC}' \
    STAGING_DIR=${STAGING_DIR_NATIVE} \
    --disable-libwebrtc \
    --disable-speex-aec \
    --disable-speex-codec \
    --enable-shared"


# prevent bitbake from calling "make clean" before configuring the package
CLEANBROKEN = "1"

do_compile_prepend() {
	oe_runmake dep
}

do_compile_append() {
	cd ${S}/pjsip-apps/src/python && oe_runmake all
}

do_install() {
	install -d ${D}${libdir}
	install -d ${D}${libdir}/${PYTHON_DIR}/site-packages
	install -m 644 ${S}/pjlib/lib/*so ${D}${libdir}
	install -m 644 ${S}/pjlib-util/lib/*so ${D}${libdir}
	install -m 644 ${S}/pjmedia/lib/*so ${D}${libdir}
	install -m 644 ${S}/pjnath/lib/*so ${D}${libdir}
	install -m 644 ${S}/pjsip/lib/*so ${D}${libdir}
	install -m 644 ${S}/third_party/lib/*so ${D}${libdir}
	install -m 644 ${S}/pjsip-apps/src/python/build/lib.*/* ${D}${libdir}/${PYTHON_DIR}/site-packages
}

FILES_${PN} += "${libdir}"
FILES_${PN} += "${libdir}/${PYTHON_DIR}"

INHIBIT_PACKAGE_DEBUG_SPLIT = "1"
INHIBIT_PACKAGE_STRIP = "1"

PACKAGES = "${PN}"
