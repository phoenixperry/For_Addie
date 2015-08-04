#  processing app that captures mouse movements and then a second app that loads and draws that data


// Second option if you need to track mouse points for extended sessions (I found the .pde running would bog my system down if ran for more than 10 mins)

// try this via terminal (assuming you're on linux LTE )

install xdotool with: sudo apt-get install xdotool

place following in a /mousetracker.sh file

###########
while :
do
    xdotool getmouselocation \
   | awk 'BEGIN{RS=" ";ORS=RS} {split($0,a,":");} a[1]~/^[xy]$/{print a[2];}'
    echo ""
    sleep 1  # delay loop one second
done

###########

run:  bash mousetracker.sh > positions.txt (you can monitor mouse coordinates in positions.txt in the terminal with tail -f positions.txt )
    
    
    // once you have a complete position.txt you can then use this .txt for the .pde draw file without cuasing memory issues 
