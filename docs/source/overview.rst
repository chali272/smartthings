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

 Devices on the SmartThings platform are represented by Device Type Handlers, virtual representations of physical devices.