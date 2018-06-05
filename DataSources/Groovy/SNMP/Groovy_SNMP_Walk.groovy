import com.santaba.agent.groovyapi.snmp.Snmp;

// Set environment variables.
def hostname = hostProps.get('system.hostname');
def props = hostProps.toProperties()
def snmp_timeout = 10000

// Set SNMP OID.
def snmp_oid       = 'INSERT_OID_HERE'; // i.e. : 1.3.6.1.2.1.1.2

// Try the following code.
try
{
    /*
    The following SNMP walk will handle v1 , v2 and v3. 
    Props contains a map of ALL host properties and the SNMP walk method will automatically
    handle the proper connection based on which SNMP version is configured.
    */

    // Create SNMP walk with defined variables and map.
    sampleWalk = Snmp.walk(hostname, snmp_oid, props, snmp_timeout);

    // Iterate through each line of the snmp output
    snmp_out.eachLine()
    { line ->

        // split on the '=' sign and get the oid and value.
        (oid, value) = line.split(/ = /, 2);

        /*
        Data post processing code goes here.
        */
    }

    // Successful script execution, return 0;
    return 0;
}

// Catch any exception that may have occurred.
catch (Exception e)
{
    // Print the exception.
    println e

    // Exit with return code 1;
    return 1;
}