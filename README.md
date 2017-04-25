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
