Running in Jmeter:
Import the existing jmx file in to Jmeter
- Click on Run


Details :
Add Thread Group
   - Number of Threads: 100 (Number of users connects to the target website: 100)
   - Ramp-Up Period: 25

Right-click on Thread Group and select: Add -> Sampler -> HTTP Request

JMeter will create the URL request https://www.google.com

Right click Test Plan, Add -> Listener -> Graph Results

Run Test and get the test result
