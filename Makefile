TOP = TopMain
BUILD_DIR = ./build
TOP_V = $(BUILD_DIR)/$(TOP).v
SCALA_FILE = $(shell find ./src/main/scala -name '*.scala')

$(TOP_V): $(SCALA_FILE)
	mkdir -p $(@D)
	sbt 'runMain top.$(TOP) -td $(@D) --output-file $@'

test:
	sbt 'test:runMain core.TestMain'

clean:
	rm -rf $(OBJ_DIR)/*
