/**
 *  HK Speaker
 *
 *  Copyright 2015 Tyler Freckmann
 *
 *  Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 *  in compliance with the License. You may obtain a copy of the License at:
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software distributed under the License is distributed
 *  on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License
 *  for the specific language governing permissions and limitations under the License.
 *
 */
metadata {
	definition (name: "HK Speaker", namespace: "tylerfreckmann", author: "Tyler Freckmann") {
		capability "Actuator"
		capability "Music Player"
		capability "Polling"
		capability "Refresh"
		capability "Sensor"
	}

	simulator {
		
	}

	tiles {
		standardTile("main", "device.status", width:2, height:2) {
        	state "paused", label:'Paused', action:"music Player.play", icon:"st.sonos.pause-icon", backgroundColor:"#ffffff"
            state "playing", label:'Playing', action:"music Player.pause", icon:"st.sonos.play-icon", backgroundColor:"#79B821"
        }
        standardTile("status", "device.status", width:2, height:2) {
        	state "paused", label:'Paused', action:"music Player.play", icon:"st.sonos.pause-icon", backgroundColor:"#ffffff"
            state "playing", label:'Playing', action:"music Player.pause", icon:"st.sonos.play-icon", backgroundColor:"#79B821"
        }
        standardTile("previousTrack", "device.status", decoration: "flat") {
        	state "previous", label:'', action:"music Player.previousTrack", icon:"st.sonos.previous-btn", backgroundColor:"ffffff"
        }
        standardTile("nextTrack", "device.status", decoration: "flat") {
        	state "next", label:'', action:"music Player.nextTrack", icon:"st.sonos.next-btn", backgroundColor: "#ffffff"
        }
        controlTile("levelSliderControl", "device.level", "slider", height:1, width:2) {
        	state "level", action:"music Player.setLevel", backgroundColor:"#ffffff"
        }
        valueTile("level", "device.level", decoration:"flat") {
        	log.debug "device.level: ${currentValue}"
			state "level", label:"${currentValue}", backgroundColor:"#ffffff"
        }
        valueTile("currentSong", "device.trackDescription", height:1, width:3, decoration:"flat") {
        	log.debug "device.level: ${currentValue}"
            state "currentSong", label:"${currentValue}", backgroundColor:"#ffffff"
        }
        standardTile("mute", "device.mute", decoration:"flat") {
        	state "unmuted", label:'', action:"music Player.mute", icon:"st.custom.sonos.unmuted", backgroundColor:"#ffffff"
            state "muted", label:'', action:"music Player.unmute", icon:"st.custom.sonos.muted", backgroundColor:"#ffffff"
        }
        standardTile("refresh", "device.status", decoration:"flat") {
        	state "refresh", label:'', action:"refresh.refresh", icon:"st.secondary.refresh", backgroundColor:"#ffffff"
        }
        
        main "main"
        details([
        	"status", "previousTrack", "nextTrack",
        	"levelSliderControl", "level",
            "currentSong",
            "mute", "refresh"
        ])
	}
}

// parse events into attributes
def parse(String description) {
	log.debug "Parsing '${description}'"
	// TODO: handle 'status' attribute
	// TODO: handle 'level' attribute
	// TODO: handle 'trackDescription' attribute
	// TODO: handle 'trackData' attribute
	// TODO: handle 'mute' attribute

}

// handle commands
def play() {
	log.debug "Executing 'play'"
	parent.play(this)
}

def pause() {
	log.debug "Executing 'pause'"
	parent.pause(this)
}

def stop() {
	log.debug "Executing 'stop'"
	parent.stop(this)
}

def nextTrack() {
	log.debug "Executing 'nextTrack'"
	parent.nextTrack(this)
}

def playTrack(track) {
	log.debug "Executing 'playTrack'"
	parent.playTrack(this, track)
}

def setLevel(level) {
	log.debug "Executing 'setLevel'"
	parent.setLevel(this, level)
}

def playText(text) {
	log.debug "Executing 'playText'"
	// TODO: handle 'playText' command
}

def mute() {
	log.debug "Executing 'mute'"
	parent.mute(this)
}

def previousTrack() {
	log.debug "Executing 'previousTrack'"
	parent.previousTrack(this)
}

def unmute() {
	log.debug "Executing 'unmute'"
	parent.unmute(this)
}

def setTrack(track) {
	log.debug "Executing 'setTrack'"
	parent.setTrack(this, track)
}

def resumeTrack(track) {
	log.debug "Executing 'resumeTrack'"
	// TODO: handle 'resumeTrack' command
}

def restoreTrack(track) {
	log.debug "Executing 'restoreTrack'"
	// TODO: handle 'restoreTrack' command
}

def poll() {
	log.debug "Executing 'poll'"
    parseEventData()
}

def refresh() {
	log.debug "Executing 'refresh'"
	parseEventData()
}

def parseEventData(Map deviceInfo) {
    // status
    sendEvent(name:"status", value:(deviceInfo["IsPlaying"] ? "playing" : "paused"))
    // level
    sendEvent(name:"level", value: deviceInfo["Volume"])
    // trackDescription
    sendEvent(name:"trackDescription", value: deviceInfo["CurrentSong"])
    // mute
    sendEvent(name:"mute", value:(deviceInfo["Volume"]==0 ? "muted" : "unmuted"))
}

def generateEvent(Map results) {
	results.each { name, value ->
    	sendEvent(name: name, value: value)
    }
}



