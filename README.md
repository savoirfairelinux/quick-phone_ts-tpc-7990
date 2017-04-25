quick-phone for TS-TCP-7990
=========

This is a collection of scripts to build an image for the [TS-TCP-7990](https://www.embeddedarm.com/products/TS-TPC-7990)
which runs the [quick-phone](https://github.com/savoirfairelinux/quick-phone) on boot.

This is done in Docker/CQFD environment using Yocto.

## Build Instructions

Just run `make`

Note that this will take a while the first time. It will first create a docker
container for the Yocto build and then run the Yocto scripts.

## Dependencies

1. Docker software installed and running
2. $USER belongs to the docker group
(see https://docs.docker.com/engine/installation/linux/fedora/ for ex.)
3. Lots of patience to build Yocto

## Configuration

Currently the image is configured to get a dynamic address via dhcp,
you will need to modify this if you wish to use a static address.

See the [quick-phone](https://github.com/savoirfairelinux/quick-phone)
repo readme to find out how to configure your SIP account and
populate your contacts.

## TODOs

* Move meta-quickphone layer and recipes to [meta-sfl](https://github.com/savoirfairelinux/meta-sfl)
  to separate build scripts from yocto recipes
* Improve alsa config so that it works well by default
* Remove X11, we can run the app in just the framebuffer
* Replace X11 launch script with systemd script
