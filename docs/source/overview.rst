HKWirelessHD SmartThings Integration Overview
=============================================

HKWirelessHD is an SDK that enables control of certain Harman Kardan devices (speakers) over Wi-Fi. It supports iOS/Android development and utilizes iOS to enable a RESTful Web API. Please visit the `Harman Developer web site <http://developer.harman.com>`__ to download and familiarize yourself with this SDK. 

.. note::

	As this SDK is still in its early stages, the HKWHub iOS app is necessary in order to support REST Web API functionality, which SmartThings integration relies upon. We hope to eliminate this limitation in the future by exploring cross-platform and true "cloud" solutions as well as exploring other ways to integrate with SmartThings, but please bear with us for the time being.


SmartThings is a platform designed for the Internet of Things and "Smart Home" automation. They offer a platform to develop "SmartApps," which connect different smart devices in the home. This platform allows integration of SmartThings devices as well as smart devices developed by other companies by abstracting away much of the architecture behind the Internet of Things. Please familiarize yourself with the `SmartThings platform <http://www.smartthings.com/developers/>`__ as well.

What's Included
---------------

- SmartThings Integration files (for reference):
	- `HKSpeaker.groovy <../../../HKSpeaker.groovy>`__
	- `HKServiceManager.groovy <../../../HKServiceManager.groovy>`__

How It Works
------------

The basic idea of the SmartThings platform is to connect all of your devices and define "SmartApps" to automate them. (These SmartApps run on the SmartThings platform).

From the SmartThings documentation:

	Each device in SmartThings has "capabilities", which define and standardize available attributes and commands for a device. This allows you to develop an application for a device type, regardless of the connection protocol or the manufacturer.

This abstraction is defined by the "Device Type Handler", which in our case is `HKSpeaker.groovy <../../../HKSpeaker.groovy>`__.

Devices connect to the SmartThings platform in one of three ways:

* connecting directly to the SmartThings Hub
* connecting through the "cloud"
* connecting through the Local Area Network (LAN)

HKWirelessHD compatible speakers connect through the cloud by providing SmartThings with a REST API, handled by the HKWHub iOS app. Devices that don't connect directly to the SmartThings Hub (as in our case) require a "Service Manager" SmartApp. The `HKServiceManager.groovy <../../../HKServiceManager.groovy>`__ is what allows SmartThings to make REST requests and control HKWirelessHD speakers through the HKWHub app.

