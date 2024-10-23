// Guest List and RSVP UI Pseudocode

class GuestListUI:
    properties:
        - eventManager (instance of EventManager)
        - contactManager (instance of ContactManager)
        - rsvpManager (instance of RSVPManager)

    methods:
        - displayGuestList(event):
            - for each guest in event.guestList:
                - display guest name and current RSVP status
                - provide buttons/drop-down for updating RSVP status (Attending, Not Attending, Not Responded)

        - addGuest(event):
            - display a list of available contacts from contactManager.contactList
            - allow the user to select contacts and add them to event.guestList
            - call eventManager.addGuestToEvent() to update the guest list

        - updateRSVP(event, contact):
            - on RSVP status change (e.g., using a drop-down or button), call rsvpManager.updateRSVP(contact, status)
            - refresh guest list view to display updated RSVP status
