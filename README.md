#  processing app that captures mouse movements and then a second app that loads and draws that data


Second option-- to track only the mouse points for extended sessions (I found the .pde to bog down my sister if ran for more than 10 mins)

try this via terminal (assuming you're on linux LTE-- Addie tested/did this!)

1) install xdotool with:
   sudo apt-get install xdotool

2) place following in a /mousetracker.sh file
###########
while :
do
    xdotool getmouselocation \
   | awk 'BEGIN{RS=" ";ORS=RS} {split($0,a,":");} a[1]~/^[xy]$/{print a[2];}'
    echo ""
    sleep 1  # delay loop one second
done
###########

3) run:
    bash mousetracker.sh > positions.txt

4) monitor mouse coordinates in positions.txt with
    tail -f positions.txt
    
    
    // once you have a complete position.txt you can then use this for the .pde draw file -aw
