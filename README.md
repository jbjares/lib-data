[![Build Status](https://travis-ci.org/PersonalHealthTrain/lib-data.svg?branch=master)](https://travis-ci.org/PersonalHealthTrain/lib-data)
[![codecov](https://codecov.io/gh/PersonalHealthTrain/lib-data/branch/master/graph/badge.svg)](https://codecov.io/gh/PersonalHealthTrain/lib-data)


# lib-data
Data classes and Extension Functions that are common to all PHT components.
 
This is the root of the PHT Library.

# Overview

## Data Classes

The following Data Classes are provided:

Class name              | Purpose
------------------------|---------------------------------------
`DockerContainerId`     | Represents the ID of a Docker Container
`DockerContainerOutput` | Represents Output of a Container when exited
`DockerImageId`         | Represents the ID of a Docker Image
`DockerNetworkid`       | Represents the ID of a Docker Network

## Extension Functions

This library also provides the following extension functions:

Class name            | Function Name         | Description
----------------------|-----------------------|----------------------------------------------------------------------------------------
`Map<String, String>` | `asKeyValueList`      | Maps the key-value pairs of the map down to a List with `<key><sep><value>` as entries.
`String`              | `ensureTrailing`      | Ensures that the String ends with the specified character.
`String`              | `ensureTrailingSlash` | Ensures that the String ends with the '/' character.
