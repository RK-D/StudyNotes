 #cmake file for project association                     #表示注释
 #author: rookie
 #created:>--2020/05/14


cmake_minimum_required(VERSION 3.5) #cmake 最低版本要求，低于3.5构建过程会被终止。

project(study)                                   #定义工程名称

 MESSAGE(STATUS "Project:  study")               #打印相关消息消息
 MESSAGE(STATUS "Project Directory: ${PROJECT_SOURCE_DIR}")

# Add the source in project root directory
#aux_source_directory(. DIRSRCS)#包含主文件夹下的main.cpp文件
# Add header file include directories
#include_directories(basic basic)#添加多目录的路径
set(CMAKE_CXX_STANDARD 11)
#SET(CMAKE_BUILE_TYPE DEBUG)

# Target
add_executable(study main.cpp "basic")#上述方法有问题，这种方法才有效

#ADD_SUBDIRECTORY("basic")                              #添加子目录