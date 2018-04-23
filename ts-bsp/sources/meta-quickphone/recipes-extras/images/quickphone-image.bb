SUMMARY = "The quick-phone image"

#IMAGE_FEATURES += "x11-base"

IMAGE_INSTALL += "packagegroup-machine-base packagegroup-core-boot packagegroup-core-full-cmdline packagegroup-qt5-toolchain-target linux-firmware bash-completion fbset libmodbus fbgrab fontconfig freetype util-linux-mkfs e2fsprogs alsa-utils-alsamixer i2c-tools quick-phone"

IMAGE_INSTALL_append = "\
    ttf-dejavu-sans \
    ttf-dejavu-sans-mono \
    ttf-dejavu-sans-condensed \
    ttf-dejavu-serif \
    ttf-dejavu-serif-condensed \
    ttf-dejavu-common \
    "

LICENSE = "MIT"
IMAGE_FSTYPES = "sdcard"

inherit core-image
