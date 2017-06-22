set shell = createobject("wscript.shell")
On Error Resume Next
shell.AppActivate "Firefox"
wscript.sleep 2000
success = shell.appactivate("Firefox")
if success then shell.sendkeys "% n"  '...minimize
wscript.quit