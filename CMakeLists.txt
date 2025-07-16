cmake_minimum_required(VERSION 3.5...3.29)

find_package(Java 1.8)

if(NOT Java_FOUND)
  message(FATAL_ERROR No
                      compatible
                      Java
                      found)
endif()

include(UseJava)
project(jdbccts NONE)

set(PLATFORM_TCK_DIR ../platform-tck CACHE STRING "Path to 'https://github.com/jakartaee/platform-tck.git' source tree")

file(GLOB JAVA_SRC_FILES ${PLATFORM_TCK_DIR}/src/com/sun/ts/tests/jdbc/ee/*/*/*.java src/org/duckdb/jdbccts/*.java)
set(CMAKE_JAVA_INCLUDE_PATH ${PLATFORM_TCK_DIR}/src src)
add_jar(jdbccts ${JAVA_SRC_FILES})
