Programming Guide
=================

In this chapter, we will explain what the Device Type Handler for the HKWirelessHD speaker does.

Music Player Device Type Handler for HKWirelessHD Speakers
----------------------------------------------------------

.. note::
	The Music Player was originaly defined for Sonos speakers, so some of the attributes and commands are just stubs, or do not make the most logical sense. Hopefully, in the future, the SmartThings Music Player definition will also be well suited for HKWirelessHD speakers.

**Attributes:**

================ ======= =================
Attribute        Type    Possible Values
================ ======= =================
status           String  ``"playing"``
                         ``"paused"``
level            Number  ``0-50``
trackDescription String  ``description of the current playing track``
trackData        JSON    ``not implemented``
mute             String  ``"muted"``
                         ``"unmuted"``
================ ======= =================

**Commands:**

*play()*
    If the speaker is paused, resume playback, otherwise, play first song in playlist
*pause()*
    Pause music playback
*stop()*
    Stop music playback
*nextTrack()*
    Advance to next track
*playTrack(string)*
    Play the track matching the given string (the string is the title for the track to be played)
*setLevel(number)*
    Set the volume to the specified level (0-50)
*playText(string)*
    Not implemented
*mute()*
    Mute playback
*previousTrack()*
    Go back to the previous track
*unmute()*
    Unmute playback
*setTrack(string)*
    Not implemented
*resumeTrack()*
    Resume music playback
*restoreTrack(map)*
    Not implemented

**SmartApp Example:**

.. code-block:: groovy

  preferences {
    section("Title") {
      input "player", "capability.musicPlayer", title: "music player", required: true, multiple: false
      input "frontDoor", "capability.contactSensor", title: "front door", required: true, multiple: false
    }
  }

  def installed() {
    subscribe(frontDoor, "contact", myHandler)
  }

  def myHandler(evt) {
    if("open" == evt.value) {
      player.play()
    }
  }

