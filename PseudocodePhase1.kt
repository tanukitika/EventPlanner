// RSVP Manager Pseudocode

class RSVPManager:
    methods:
        - updateRSVP(contact, status):
            - set contact's RSVP status to the provided status (e.g., Attending, Not Attending)

        - getRSVPStatus(contact):
            - return contact's RSVP status

        - generateRSVPReport(event):
            - loop through event.guestList
            - count how many guests have RSVPed as 'Attending', 'Not Attending', and 'Not Responded'
            - return RSVP report summary
