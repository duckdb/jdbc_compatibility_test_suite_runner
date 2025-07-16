.PHONY: all jar clean update test

all: jar

clean:
	rm -rf build

jar:
	mkdir -p build && cd build && cmake .. && cmake --build .

test: jar
	java -cp $(DUCKDB_JAR):build/jdbccts.jar -Dcurrent.dir=${PLATFORM_TCK_DIR}/src/com/sun/ts/tests/jdbc/ee -Dexclude.list=exclude org.duckdb.jdbccts.TestRunner -p props
