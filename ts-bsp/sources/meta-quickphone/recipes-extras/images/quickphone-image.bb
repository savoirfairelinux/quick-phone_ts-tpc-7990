SUMMARY = "The quick-phone image"
LICENSE = "MIT"

# Work around an issue in Technologic System's layer. `IMAGE_INSTALL +=` is used
# in tsimx6.conf, which is a machine file. This is wrong as machine files should
# use MACHINE_{ESSENTIAL,}_EXTRA_{RDEPENDS,RRECOMMENDS} to install
# machine-specific packages, and using `+=` to modify IMAGE_INSTALL is
# discouraged because it ends up in unexpected situations. In our case,
# packagegroup-base ended up not being installed, and VPU firmwares were missing
# from the final image. So to work around that, we assign a new value to
# IMAGE_INSTALL
IMAGE_INSTALL_tsimx6 = "\
    packagegroup-core-boot \
    packagegroup-base-extended \
    \
    ${CORE_IMAGE_EXTRA_INSTALL} \
    \
    ts4900-fpga \
    kernel-devicetree \
    linux-firmware \
    ts4900-utils"

# list of packages that are specific to this image
IMAGE_INSTALL_append = " \
    packagegroup-core-full-cmdline \
    packagegroup-fonts-truetype-core \
    packagegroup-qt5-toolchain-target \
    alsa-utils-alsamixer \
    bash-completion \
    fbset \
    fbgrab \
    freetype \
    i2c-tools \
    libmodbus \
    linux-firmware \
    quick-phone \
    systemd-machine-units \
    ttf-dejavu-sans-condensed \
    ttf-dejavu-serif \
    ttf-dejavu-serif-condensed \
    util-linux-mkfs"

inherit core-image
