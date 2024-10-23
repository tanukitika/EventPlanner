// Event Manager + Contact & RSVP Managers Pseudocode

class EventManager:
    properties:
        - eventList (list of events)
        - contactManager (instance of ContactManager)
        - rsvpManager (instance of RSVPManager)

    methods:
        - createEvent(name, date, time, location, description):
            - initialize Event object with provided details
            - add empty guest list
            - return Event object

        - addGuestToEvent(event, contact):
            - add contact from contactManager to event's guestList
            - return updated event guestList

        - updateRSVP(event, contact, status):
            - call rsvpManager.updateRSVP(contact, status)
            - return updated RSVP status

        - getRSVPReport(event):
            - call rsvpManager.generateRSVPReport(event)
            - return RSVP report for that event

        - editEvent(event, newDetails):
            - update event details
            - return updated event

        - deleteEvent(event):
            - remove event from eventList
            - return confirmation of deletion

        - getEventGuestList(event):
            - return list of guests for the event (stored in event.guestList)
