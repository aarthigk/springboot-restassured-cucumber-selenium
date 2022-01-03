
Feature: Feature to access pet store

  Scenario: Create a pet id
    Given the user requests to "pet" api on service "pet store"
		And the payload is
		"""
   	{
  "id": 0,
  "category": {
    "id": 0,
    "name": "string"
  },
  "name": "doggie",
  "photoUrls": [
    "string"
  ],
  "tags": [
    {
      "id": 0,
      "name": "string"
    }
  ],
  "status": "available"
}	
	 """
		When the "post" request is sent
		Then the status code will be "200"

