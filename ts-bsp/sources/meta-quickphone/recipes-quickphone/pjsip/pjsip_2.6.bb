#
# This file was derived from the 'Hello World!' example recipe in the
# Yocto Project Development Manual.
#

DESCRIPTION = "PJSIP stack"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

SRC_URI[md5sum] = "c347a672679e7875ce572e18517884b2"
SRC_URI[sha256sum] = "2f5a1da1c174d845871c758bd80fbb580fca7799d3cfaa0d3c4e082b5161c7b4"

inherit autotools pythonnative
INSANE_SKIP_${PN} = "ldflags"

PR = "r0"

SRC_URI = "http://www.pjsip.org/release/2.6/pjproject-2.6.tar.bz2"

S = "${WORKDIR}/pjproject-2.6/"

DEPENDS = "alsa-lib util-linux python-dev"
RDEPENDS_${PN} += "python-threading"

EXTRA_OECONF += "STAGING_DIR=${STAGING_DIR_NATIVE}"
export BUILD_SYS
export HOST_SYS
export STAGING_INCDIR
export STAGING_LIBDIR

EXTRA_OECONF="--disable-libwebrtc --disable-speex-aec --disable-speex-codec --enable-shared"

do_configure_prepend() {
	export LD="${CC}"
}

do_configure() {
	cd ${S} && oe_runconf
}

do_compile_prepend() {
	cd ${S} && oe_runmake dep
}

do_compile() {
	cd ${S} && oe_runmake all
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
