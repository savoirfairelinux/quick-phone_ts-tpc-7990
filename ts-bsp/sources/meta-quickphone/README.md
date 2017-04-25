This README file contains information on the contents of the
quickphone layer.

Please see the corresponding sections below for details.


Dependencies
============

This layer depends on:

  URI: git://git.openembedded.org/bitbake
  branch: master

  URI: git://git.openembedded.org/openembedded-core
  layers: meta
  branch: master

  URI: https://github.com/embeddedarm/ts-oe-bsp.git
  layers: meta-ts
  branch: master

Patches
=======

Please submit any patches against the quickphone layer to the
SFL github account: https://github.com/savoirfairelinux/quick-phone_ts-tpc-7990


Table of Contents
=================

  I. Adding the quickphone layer to your build


I. Adding the quickphone layer to your build
=================================================

In order to use this layer, you need to make the build system aware of
it.

Assuming the quickphone layer exists at the top-level of your
yocto build tree, you can add it to the build system by adding the
location of the quickphone layer to bblayers.conf, along with any
other layers needed. e.g.:

  BBLAYERS ?= " \
    /path/to/yocto/meta \
    /path/to/yocto/meta-yocto \
    /path/to/yocto/meta-yocto-bsp \
    /path/to/yocto/meta-ts \
    /path/to/yocto/meta-quickphone \
    "
