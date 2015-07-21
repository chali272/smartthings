Getting Started
===============

Setup
-----

Download HKWHub iOS app
~~~~~~~~~~~~~~~~~~~~~~~

- Go to the `Harman Developer web site <http://developer.harman.com>`__ and click on Developer Tools > Download SDK > iOS > Sample Apps.
- Find the HKWHub App and download it.

Prepare your router so that the HKWHub app can handle REST requests
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

- Configure your router's DMZ host to be the IP address that is displayed on the HKWHub app's home page.


Register for a free SmartThings developer account
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

- Go to the `SmartThings web site <http://www.smartthings.com/developers/>`__, click on "Getting Started", and follow the brief SmartThings tutorial.

Incorporate the HKWirelessHD speaker Device Handler and Service Manager into your account
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

- Create a Device Handler called ``HKSpeaker`` and paste the contents of `HKSpeaker.groovy <../../../HKSpeaker.groovy>`__ into it.
	- Publish this Device Handler for yourself in "My Apps"
- Create a SmartApp called ``HKServiceManager`` and paste the contents of `HKServiceManager.groovy <../../../HKServiceManager.groovy>`__ into it.
	- Configure the Service Manager's ipAddress setting to be your router's public IP address (which you can find by googling "my ip address" from the device running the HKWHub app).
	- Publish this Service Manager for yourself in "My Apps"

Now you should be able to create your own SmartApps that incorporate HKWirelessHD compatible speakers! In the SmartThings app on your phone, you can press the "+" symbol and scroll all the way to the right to My Apps to download the HK Service Manager. When you open the Service Manager, you should be walked through a process to select which HKWirelessHD compatible speakers you want to connect to SmartThings. Once you've installed the Service Manager (by clicking "Done"), you will see HKWirelessHD speakers in your list of devices, and you should be able to control them from that interface.

The Service Manager has now incorporated your HKWirelessHD speakers into the SmartThings platform as ``musicPlayer``\ s, which have the capabilities defined in the SmartThings documentation under `Music Player <http://docs.smartthings.com/en/latest/capabilities-reference.html#music-player>`__.

Creating a Sample SmartApp
--------------------------

In this section we will explain how to create a SmartApp that incorporates an HKWirelessHD device. We will create a simple SmartApp called "Welcome Home," that will play a song when a door is opened.

Step 1: Create a new SmartApp
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

Go to your `developer environment page <https://graph.api.smartthings.com/>`__, and create a new SmartApp.

Step 2: Select the Contact Sensor and Speaker
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

In the ``preferences`` definition, create sections for the user to select a ``contactSensor`` and a ``musicPlayer``:

.. code-block:: groovy

	preferences {
		// Select the contact sensor
		section ("Which contact sensor?") {
			input "contact", "capability.contactSensor", title: "Which?"
		}
		// Select the speaker
		section ("Which HK Speaker?") {
			input "speaker", "capability.musicPlayer", title: "Which?"
		}
	}

Step 3: Subscribe to Event
~~~~~~~~~~~~~~~~~~~~~~~~~~

In the ``initialize`` method, subscribe to the ``contactSensor``:

.. code-block:: groovy

	def initialize() {
		subscribe(contact, "contact", contactHandler)
	}

Step 4: Define the event handler
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

Create a new method to handle the ``contact`` event:

.. code-block:: groovy

	def contactHandler(evt) {
		log.debug "door ${evt.value}"

		// If the door is open, play a song
		if (evt.value == "open") {
			speaker.play();
		}
	}

Step 5: Publish it and test it
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

Publish your SmartApp for yourself and see if it works!

