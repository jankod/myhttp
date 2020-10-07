@import hr.ja.myhttp.model.User

@import 'in
@param User user

<html>

<body>

@for(int i = 0; i< 22; i++)
    <b>this is i = ${i}</b>
@endfor

<p>${user.getName()}</p>

@if(user.getName().equals(""))
    <b>This is pero</b>
@endif

@tag.drawEntry(entry = user, verbose = User)
</body>
</html>
