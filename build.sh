#!/bin/bash

export PATH=$PATH:$PWD/ts-bsp/sources/poky/scripts:$PWD/ts-bsp/sources/poky/bitbake/bin
cd $PWD/ts-bsp
export MACHINE="tsimx6"
source ./setup-environment build
bitbake quickphone-image
