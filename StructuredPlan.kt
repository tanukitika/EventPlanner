Layer	File Name	Purpose
Backend Logic (Model)	
    ContactManager.kt:	            Manages and stores contact data.
    EventManager.kt:	              Manages event creation, editing, and deletion.
    RSVPManager.kt:	                Manages RSVP statuses and generates RSVP reports.
Views (UI Layer)	
    activity_main.xml:             	Main screen layout, containing navigation options.
    activity_create_event.xml:      Layout for creating a new event (input fields for event info).
    activity_event_details.xml:    	Displays event details, including the guest list and RSVP data.
    activity_guest_list.xml:      	Displays the guest list for an event.
Controllers (Activities)	
    MainActivity.kt:                Manages the main screen, navigation, and interaction.
    CreateEventActivity.kt:        	Handles user input for creating a new event.
    EventDetailsActivity.kt:       	Displays and manages event details and RSVPs.
    GuestListActivity.kt:          	Manages the display and interaction with the guest list.
