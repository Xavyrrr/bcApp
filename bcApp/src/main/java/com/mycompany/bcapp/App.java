package com.mycompany.bcapp;

import NonFrames.FileHexConverter;
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
            String t = new FileHexConverter().hexToString("7b2273656e646572223a2231333447467873517458613767386e6e737074374e3939625632364d70374553754c41636b33222c226c6f636174696f6e223a22433a5c5c7064667465737466696c652e706466222c2268617368223a223163626362373763666136626164393866643630303363393564313965373236227d");
                result = multiChainCommand.getAddressCommand().getAddresses();
                balance = multiChainCommand.getBalanceCommand().getTotalBalances();
                permissions = multiChainCommand.getGrantCommand().listPermissions();
                //SendAssetFrame frame = new SendAssetFrame();
                OverViewFrame frame = new OverViewFrame();
                frame.setVisible(true);
        } catch (MultichainException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
        }
        System.out.println( "Hello World!" );
    }
}
