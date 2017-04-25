BSP_DIR=$(PWD)/ts-bsp
BSP_BUILD_DIR=$(BSP_DIR)/build

default: $(BSP_BUILD_DIR)
	$(PWD)/.cqfd/cqfd

$(BSP_BUILD_DIR):
	$(PWD)/.cqfd/cqfd init
	$(PWD)/prep.sh

all: default

distclean:
	rm -rf $(BSP_BUILD_DIR)
