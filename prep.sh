#!/bin/bash

test -f ./bin/repo || {
    test -d ./bin || mkdir ./bin
    curl http://commondatastorage.googleapis.com/git-repo-downloads/repo > ./bin/repo
    chmod a+x ./bin/repo
}
export PATH=$PATH:`pwd`/bin

# Check out TS BSP:
cd ts-bsp
# Fido is the most tested branch for the TS-4900.  We also have a Jethro and Fido branch
# TS-7970/TS-7990 should use at least Krogoth.
repo init -u https://github.com/embeddedarm/ts-oe-bsp.git -b morty
repo sync # This will take a while while it downloads around 10 git repos

# Once it is downloaded the environment needs to bet set up:
## The SDK will default to the architecture of the build system
## or you can override it with one of the following:
# export SDKMACHINE="x86_64"
# export SDKMACHINE="i686"
# Generate the image based on quad or solo
export MACHINE="tsimx6"
export DISTRO="poky"
## The SDK and MACHINE can be changed later by modifying build/conf/local.conf
echo `pwd`
source ./setup-environment build

# Next replace the newly generated contents of conf/bblayers.conf with this:
cat <<'EOF' > conf/bblayers.conf
LCONF_VERSION = "6"

BBPATH = "${TOPDIR}"
BSPDIR := "${@os.path.abspath(os.path.dirname(d.getVar('FILE', True)) + '/../..')}"

BBFILES ?= ""
BBLAYERS = " \
	${BSPDIR}/sources/poky/meta \
	${BSPDIR}/sources/poky/meta-yocto \
	${BSPDIR}/sources/poky/meta-yocto-bsp \
	\
	${BSPDIR}/sources/meta-openembedded/meta-oe \
	${BSPDIR}/sources/meta-openembedded/meta-systemd \
	${BSPDIR}/sources/meta-openembedded/meta-networking \
	${BSPDIR}/sources/meta-openembedded/meta-ruby \
	${BSPDIR}/sources/meta-openembedded/meta-python \
	\
	${BSPDIR}/sources/meta-freescale \
	${BSPDIR}/sources/meta-freescale-3rdparty \
	${BSPDIR}/sources/meta-freescale-distro \
	${BSPDIR}/sources/meta-ts \
	${BSPDIR}/sources/meta-qt5 \
	${BSPDIR}/sources/meta-quickphone \
"
EOF

# Edit the file conf/local.conf. To match our image, add these lines:
cat <<'EOF' >> conf/local.conf

DISTRO_FEATURES_remove = "3g \
                          bluetooth \
                          bluez5 \
                          gobject-introspection-data \
                          irda \
                          nfc \
                          nfs \
                          pcmcia \
                          usbgadget \
                          usbhost \
                          wifi \
                          zeroconf"

LICENSE_FLAGS_WHITELIST = "commercial_libav commercial"

# Skip these three if you do not want systemd
DISTRO_FEATURES_append = " systemd"
DISTRO_FEATURES_remove = " wayland x11"
VIRTUAL-RUNTIME_init_manager = "systemd"
DISTRO_FEATURES_BACKFILL_CONSIDERED = "sysvinit"
EOF
