#!/usr/bin/env perl 

use 5.010;
use utf8;
use strict;
use warnings;

use Net::Twitter::Lite;

binmode STDOUT, ':utf8';

my $query = $ARGV[0];

my $nt = Net::Twitter::Lite->new;

my $result = $nt->search($query);
for my $tweet (@{$result->{results}}) {
    say '【' . $tweet->{from_user} . ' 】' . $tweet->{text};
}

