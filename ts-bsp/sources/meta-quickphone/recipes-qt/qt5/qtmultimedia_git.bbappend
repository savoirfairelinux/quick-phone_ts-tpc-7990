PACKAGECONFIG_append = " gstreamer"

RDEPENDS_${PN}_append = " gstreamer1.0-plugins-base \
                          gstreamer1.0-plugins-bad \
                          gstreamer1.0-plugins-good"
RDEPENDS_${PN}_append_mx6 = " gstreamer1.0-plugins-imx"
