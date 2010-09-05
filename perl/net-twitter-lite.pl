#!/usr/bin/env perl 

use 5.010;
use utf8;
use strict;
use warnings;

use Encode;
use Net::Twitter::Lite;

binmode STDOUT, ':utf8';

my $query = decode_utf8($ARGV[0]);
say "search query => $query";

my $nt = Net::Twitter::Lite->new;
my $result = $nt->search(decode_utf8($query));
for my $tweet (@{$result->{results}}) {
    say '【' . $tweet->{from_user} . ' 】' . $tweet->{text};
}

