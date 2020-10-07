@import my.Entry
@param Entry entry
@param boolean verbose

<h2>${entry.title}</h2>
@if(verbose)
    <h3>${entry.subtitle}</h3>
@endif