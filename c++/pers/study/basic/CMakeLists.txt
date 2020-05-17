cmake_minimum_required(VERSION 3.15)
project(basic)

set(CMAKE_CXX_STANDARD 11)

add_executable(basic test.cpp
        "./derived"
        "./pointer"
        "./module"
        "./array"
        "./character"
        "./pointer")