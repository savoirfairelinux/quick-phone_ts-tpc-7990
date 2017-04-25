SUMMARY = "The quick-phone image"

IMAGE_FEATURES += "x11-base"

IMAGE_INSTALL += "packagegroup-machine-base packagegroup-core-boot packagegroup-core-full-cmdline packagegroup-core-x11 packagegroup-qt5-toolchain-target linux-firmware bash-completion fbset libmodbus fbgrab eglinfo-x11 cinematicexperience fontconfig freetype xinput-calibrator util-linux-mkfs e2fsprogs alsa-utils-alsamixer i2c-tools qtdeclarative-qmlplugins qtquickcontrols-qmlplugins qtquick1 pjsip quick-phone"

LICENSE = "MIT"

inherit core-image
