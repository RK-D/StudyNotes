cmake_minimum_required(VERSION 3.15)
project(basic)

set(CMAKE_CXX_STANDARD 11)

add_executable(basic test.cpp
        "./derived/derived.cpp"
        "./pointer/pointer.cpp"
        "./module/module.cpp")