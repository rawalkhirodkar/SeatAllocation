#!/bin/bash

awk -F, '{ COUNT=$4; COUNT=COUNT+1-1; print ""COUNT; }' data.csv | sort -n >plot
awk -f group.awk plot >plot1
rm plot

gnuplot <<EOF
set term png
set output "plot2.png"
set xrange[0:45]
set xlabel "Number of primes"
set ylabel "Number of occurences"
set title "Plot 2"
set nokey
plot "plot1" u 1:2 with lp
pause -1
EOF
rm plot1
