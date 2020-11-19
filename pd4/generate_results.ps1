For ($i=1; $i -le 5; $i++) {
	
    Invoke-Expression ("mongo nbd zapytanie_" + $i + "_MR.js >> wyniki_" + $i + "_MR.js")
	Invoke-Expression ("mongo nbd zapytanie_" + $i + "_A.js >> wyniki_" + $i + "_A.js")
	Write-Host ("mongo nbd zapytanie_" + $i + "_MR.js >> wyniki_" + $i + "_MR.js")
	Write-Host ("mongo nbd zapytanie_" + $i + "_A.js >> wyniki_" + $i + "_A.js")
}