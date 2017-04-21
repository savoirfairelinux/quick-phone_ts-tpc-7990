quick-phone for TS-TCP-7990
=========

This is a collection of scripts to build an image for the [TS-TCP-7990](https://www.embeddedarm.com/products/TS-TPC-7990)
which runs the [quick-phone](https://github.com/savoirfairelinux/quick-phone) on boot.

This is done in Docker/CQFD environment using Yocto.

## Build Instructions

First run:

`@> ./.cqfd/cqfd init`

This will create the Docker container for the Yocto build

Then run:

`make`

## Dependencies

1. Docker software installed and running
2. $USER belongs to the docker group
(see https://docs.docker.com/engine/installation/linux/fedora/ for ex.)
3. Lots of patience to build Yocto
