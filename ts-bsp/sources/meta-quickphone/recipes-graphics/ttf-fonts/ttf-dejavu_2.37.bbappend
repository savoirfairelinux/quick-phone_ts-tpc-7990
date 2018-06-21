# sadly we must override everything that was done in meta-ts
# to put it back to normal
do_install() {
    install -d ${D}${datadir}/fonts/truetype/
    find ${S} -name '*.tt[cf]' -exec install -m 0644 {} ${D}${datadir}/fonts/truetype/ \;
}

FILES_${PN}-sans            = "${datadir}/fonts/truetype/DejaVuSans.ttf ${datadir}/fonts/truetype/DejaVuSans-*.ttf"
FILES_${PN}-sans-mono       = "${datadir}/fonts/truetype/DejaVuSansMono*.ttf"
FILES_${PN}-sans-condensed  = "${datadir}/fonts/truetype/DejaVuSansCondensed*.ttf"
FILES_${PN}-serif           = "${datadir}/fonts/truetype/DejaVuSerif.ttf ${datadir}/fonts/truetype/DejaVuSerif-*.ttf"
FILES_${PN}-serif-condensed = "${datadir}/fonts/truetype/DejaVuSerifCondensed*.ttf"
FILES_${PN}-mathtexgyre     = "${datadir}/fonts/truetype/DejaVuMathTeXGyre.ttf"
