FROM ubuntu:14.04

ENV LANG en_US.utf8
ENV LC_ALL en_US.utf8
ENV HOME /home/builder

VOLUME /home/builder/src

RUN apt-get update && apt-get install -y --no-install-recommends \
    ca-certificates \
    rsync \
    unzip \
    patch \
    build-essential \
    gawk \
    libncurses5-dev \
    git \
    parted \
    kpartx \
    subversion \
    zlib1g-dev \
    autogen \
    gettext \
    zip \
    flex \
    bison \
    libtool \
    w3m \
    screen \
    automake \
    wget \
    python \
    bc \
    ssh \
    libxml2-utils \
    docbook-xml \
    dblatex \
    git-core \
    diffstat \
    unzip \
    texinfo \
    gcc-multilib \
    build-essential \
    chrpath \
    socat \
    libsdl1.2-dev \
    xterm \
    make \
    xsltproc \
    docbook-utils \
    fop \
    dblatex \
    xmlto \
    autoconf \
    automake \
    libtool \
    libglib2.0-dev \
    curl \
    && locale-gen $LANG $LC_ALL && update-locale $LANG $LC_ALL
