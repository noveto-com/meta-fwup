SUMMARY = "Configurable embedded Linux firmware update creator and runner"
DESCRIPTION = ""
HOMEPAGE = "https://github.com/fwup-home/fwup"
SECTION = "devel"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=3b83ef96387f14655fc854ddc3c6bd57"
DEPENDS = "libconfuse libarchive libsodium zlib pkgconfig-native"

SRC_URI = "git://github.com/fwup-home/fwup.git;protocol=https;branch=main"

# Modify these as desired
PV = "1.8.4"
SRCREV = "3e8924ec3c87a6148b98d6a018177d0d319ede64"

S = "${WORKDIR}/git"

CFLAGS_prepend = "-I${S} "

inherit autotools lib_package pkgconfig
FILES_${PN} += "${datadir}/bash-completion/completions/fwup \
               ${bindir}/fwup \
"

FILES_${PN}-img2fwup = "${bindir}/img2fwup"

PACKAGES = "${PN}-dev ${PN}-dbg ${PN}-img2fwup ${PN}"
BBCLASSEXTEND = "native nativesdk"

do_configure_append () {
  ln -s ${S}/src/fwup.h2m ${WORKDIR}/build/src/fwup.h2m
}
