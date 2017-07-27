package com.mycompany.bcapp;

import java.util.List;
import multichain.command.MultiChainCommand;
import multichain.command.MultichainException;
import multichain.object.BalanceAsset;
import multichain.object.Permission;

/**
 * Hello world!
 *
 */
public class App 
{
    static MultiChainCommand multiChainCommand = new MultiChainCommand("localhost", "6804", "multichainrpc","GB12hoMaU8PJRR7KsdpQFhpXjW3eDRTUZMZDWBDuDVxL");
    public static void main( String[] args )
    {
        List<String> result = null;
        List<BalanceAsset> balance = null;
        List<Permission> permissions = null;
        try {
                result = multiChainCommand.getAddressCommand().getAddresses();
                balance = multiChainCommand.getBalanceCommand().getTotalBalances();
                permissions = multiChainCommand.getGrantCommand().listPermissions();
                SendAssetFrame frame = new SendAssetFrame();
                frame.setVisible(true);
        } catch (MultichainException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
        }
        System.out.println( "Hello World!" );
    }
}
