package lss;

import java.io.BufferedReader;
import java.io.IOException;

public class Buki implements Common {

    int small = 0;                      //�����ȃ����X�^�[�_���[�W
    int big = 0;                        //�傫�ȃ����X�^�[�_���[�W
    String name = "";                   //����̖��O
    String type = "";                   //����̎��
    double critical_rate = 0;           //�N���E �N���e�B�J��
    double double_hit_rate = 0;         //�f���A���u���[�h �_�u���q�b�g
    double week_point_exposure = 0;     //�`�F�[���\�[�h ��_�I�o
    boolean two_hands = false;          //���茕(true)���茕�ȊO(false)
//    String equip = "";
    String material = "";               //�ގ�
    Buff op = new Buff();               //����1�̃I�v�V����
    Buff op2 = new Buff();              //����2�̃I�v�V����
    int enchant = 0;                    //�����l
    int magic_enchant = 0;              //����ɑ΂��Č��ʂ̂���ǉ����@�_���[�W
    int max_enchant = 0;                //�ō��\�����l
    int safety = 0;                     //���S�����l
    boolean element_enchant = false;    //����������
    boolean damage_resistance = false;  //�����ϐ�
    // �L�[�����N�p
    int x, y, z;                        //�L�[�����N�p�_���[�W�_�C�X
    // ���@����p
    String magic_name = "";             //���@����̖��@�̖��O
//    boolean magic_motion = false;       //���@���[�V�����̗L��
    double magic_rate = 0;              //���@������
    double magic_rate_plus = 0;         //����+1���̖��@������
    String magic_element = "";          //���@����
    double magic_power = 0;             //���@��{�_���[�W
    double magic_delay = 0;             //���@�f�B���C
//    int buki_weight = 0;                //����̏d��

    //��̐ݒ���
    String arrow_name = "";             //��̖��O
    int arrow_elementdmg = 0;           //���푮���_���[�W
    int arrow_dmg = 0;                  //�������_���[�W
    int arrow_hit = 0;                  //����������
    String arrow_material = "";         //�ގ�
//    int arrow_weight = 0;               //��̏d��

    private void reset() {
        //����̏����ݒ�
        small = 0;                      //�����ȃ����X�^�[�_���[�W
        big = 0;                        //�傫�ȃ����X�^�[�_���[�W
        name = "";                      //����̖��O
        type = "";                      //����̎��
        critical_rate = 0;              //�N���E �N���e�B�J��
        double_hit_rate = 0;            //�f���A���u���[�h �_�u���q�b�g
        week_point_exposure = 0;        //�`�F�[���\�[�h ��_�I�o
        two_hands = false;              //���茕(true)���茕�ȊO(false)
//        equip = "";
        material = "";                  //�ގ�
        op = new Buff();                //����1�̃I�v�V����
        op2 = new Buff();               //����2�̃I�v�V����
        enchant = 0;                    //�����l
        magic_enchant = 0;              //����ɑ΂��Č��ʂ̂���ǉ����@�_���[�W
        max_enchant = 0;                //�ō��\�����l
        safety = 0;                     //���S�����l
        element_enchant = false;        //����������
        damage_resistance = false;      //�����ϐ�
        magic_name = "";                //���@����̖��@�̖��O
//        magic_motion = false;           //���@���[�V�����̗L��
        magic_rate = 0;                 //���@������
        magic_rate_plus = 0;            //����+1���̖��@������
        magic_element = "";             //���@����
        magic_power = 0;                //���@��{�_���[�W
        magic_delay = 0;                //���@�f�B���C
//        buki_weight = 0;                //����̏d��

        //��̏����ݒ�
        arrow_name = "";                //��̖��O
        arrow_elementdmg = 0;           //���푮���_���[�W
        arrow_dmg = 0;                  //�������_���[�W
        arrow_hit = 0;                  //����������
        arrow_material = "";            //�ގ�
//        arrow_weight = 0;               //��̏d��
    }

    void load(BufferedReader reader) {
        reset();
        if (reader == null) {
            return;
        }
        try {
            reader.mark(1_000_000);
            reader.reset();
            op.loadOption(reader);
            reader.reset();
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.startsWith("small=")) {
                    small = Integer.parseInt(line.split("=")[1]);
                }
                if (line.startsWith("big=")) {
                    big = Integer.parseInt(line.split("=")[1]);
                }
                if (line.startsWith("type=")) {
                    type = line.split("=")[1];
                }
                if (line.startsWith("�_���[�W�_�C�X=")) {
                    x = Integer.parseInt(line.split("=")[1].split("d")[0]);
                    y = Integer.parseInt(line.split("=")[1].split("d")[1]
                            .split("\\+")[0]);
                    z = Integer.parseInt(line.split("=")[1].split("d")[1]
                            .split("\\+")[1]);
                }
//                if (line.startsWith("equip=")) {
//                    equip = line.split("=")[1];
//                }
                if (line.startsWith("name=")) {
                    name = line.split("=")[1];
                }
                if (line.startsWith("�N���e�B�J��=")) {
                    critical_rate = Double.parseDouble(line.split("=")[1]);
                }
                if (line.startsWith("�_�u���q�b�g=")) {
                    double_hit_rate = Double.parseDouble(line.split("=")[1]);
                }
                if (line.startsWith("���S=")) {
                    safety = Integer.parseInt(line.split("=")[1]);
                }
                if (line.startsWith("�������E=")) {
                    max_enchant = Integer.parseInt(line.split("=")[1]);
                }
                if (line.startsWith("�ގ�=")) {
                    material = line.split("=")[1];
                }
                if (line.startsWith("���蕐��=")) {
                    two_hands = Boolean.parseBoolean(line.split("=")[1]);
                }
                if (line.startsWith("��������=")) {
                    element_enchant = Boolean.parseBoolean(line.split("=")[1]);
                }
                if (line.startsWith("�����ϐ�=")) {
                    damage_resistance = Boolean.parseBoolean(line.split("=")[1]);
                }
                if (line.startsWith("���@�_���[�W=")) {
                    magic_power = Double.parseDouble(line.split("=")[1]);
                }
                if (line.startsWith("���@������=")) {
                    magic_rate = Double.parseDouble(line.split("=")[1]);
                }
//                if (line.startsWith("���@���[�V����=")) {
//                    magic_motion = Boolean.parseBoolean(line.split("=")[1]);
//                }
                if (line.startsWith("���@����=")) {
                    magic_element = line.split("=")[1];
                }
                if (line.startsWith("���@����������=")) {
                    magic_rate_plus = Double.parseDouble(line.split("=")[1]);
                }
                if (line.startsWith("���@=")) {
                    magic_name = line.split("=")[1];
                }
                if (line.startsWith("���@�f�B���C=")) {
                    magic_delay = Double.parseDouble(line.split("=")[1]);
                }
                if (line.startsWith("��_�I�o=")) {
                    week_point_exposure = Double
                            .parseDouble(line.split("=")[1]);
                }
//                if (line.startsWith("�d��=")) {
//                    buki_weight = Integer.parseInt(line.split("=")[1]);
//                }
            }
        } catch (IOException | NullPointerException e) {
//            System.err.println(e);

        }
    }

    public void loadArrow(BufferedReader reader) {
        try {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.startsWith("name")) {
                    arrow_name = line.split("=")[1];
                }
                if (line.startsWith("�����_���[�W")) {
                    arrow_elementdmg = Integer.parseInt(line.split("=")[1]);
                }
                if (line.startsWith("�ǉ��_���[�W")) {
                    arrow_dmg = Integer.parseInt(line.split("=")[1]);
                }
                if (line.startsWith("����������")) {
                    arrow_hit = Integer.parseInt(line.split("=")[1]);
                }
                if (line.startsWith("�ގ�")) {
                    arrow_material = line.split("=")[1];
                }
//                if (line.startsWith("�d��=")) {
//                    arrow_weight = Integer.parseInt(line.split("=")[1]);
//                }
            }

        } catch (IOException | NullPointerException e) {
        }
    }

    public void checkEnchant() {
        op2 = new Buff();
        //�ґz�̃X�^�b�t
        if (name.equals("�ґz�̃X�^�b�t")) {
            op2.MPR += enchant;
        }
        //�����̐�����
        if (name.equals("�����̐�����")) {
            if (enchant >= 9) {
                op2.ST[CHA] += 1;
            }
        }

        //�n���E�B������*8���                                                   ����1����PVP�_���[�W+1
        if (name.equals("�n���E�B���\�[�h") || name.equals("�n���E�B���c�[�n���h�\�[�h") || name.equals("�n���E�B���A�b�N�X") || name.equals("�n���E�B���X�^�b�t") || name.equals("�n���E�B���f���A���u���[�h") || name.equals("�n���E�B���`�F�[���\�[�h") || name.equals("�n���E�B���L�[�����N") || name.equals("�n���E�B���{�E")) {
            op2.PVP += enchant;                                                 //PVP�_���[�W+������
        }

        //�o�t�H���b�g�X�^�b�t                                                   +7�ȍ~����1����SP+1(+9�܂œK�p)
        if (name.equals("�o�t�H���b�g�X�^�b�t")) {
            if (enchant >= 9) {
            op2.SP += 3;                                                        //SP+3
            } else if (enchant >= 8) {
            op2.SP += 2;                                                        //SP+2
            } else if (enchant >= 7) {
            op2.SP += 1;                                                        //SP+1
            }
        }

        //�e���y�X�g�A�b�N�X                                                     +8�ȍ~����1���ɋ��|�I��+1(+10�����܂œK�p)
        if (name.equals("�e���y�X�g�A�b�N�X") || name.equals("�e���y�X�g�A�b�N�X(�ޗ�����)")) {
            if (enchant >= 10) {
            op2.ailment[HIT_TERROR] += 3;                                       //���|�I��+3
            } else if (enchant >= 9) {
            op2.ailment[HIT_TERROR] += 2;                                       //���|�I��+2
            } else if (enchant >= 8) {
            op2.ailment[HIT_TERROR] += 1;                                       //���|�I��+1
            }
        }

        //�r�Ŏ҂̃`�F�[���\�[�h                                                 +7�ȍ~����1���ɔ�Z����+1(+10�����܂œK�p)
        if (name.equals("�r�Ŏ҂̃`�F�[���\�[�h") || name.equals("�r�Ŏ҂̃`�F�[���\�[�h(�r�Ŕ���)")) {
            if (enchant >= 10) {
            op2.ailment[HIT_SECRET] += 4;                                       //��Z����+4
            } else if (enchant >= 9) {
            op2.ailment[HIT_SECRET] += 3;                                       //��Z����+3
            } else if (enchant >= 8) {
            op2.ailment[HIT_SECRET] += 2;                                       //��Z����+2
            } else if (enchant >= 7) {
            op2.ailment[HIT_SECRET] += 1;                                       //��Z����+1
            }
        }

        //�k�{�̃N���E                                                           +8�ȍ~����1���ɐ��얽��+1(+10�����܂œK�p)
        if (name.equals("�k�{�̃N���E")) {
            if (enchant >= 10) {
            op2.ailment[HIT_SPIRIT] += 3;                                       //���얽��+3
            } else if (enchant >= 9) {
            op2.ailment[HIT_SPIRIT] += 2;                                       //���얽��+2
            } else if (enchant >= 8) {
            op2.ailment[HIT_SPIRIT] += 1;                                       //���얽��+1
            }
        }

        //�E�ӂ̃L�[�����N                                                       +7�ȍ~����1���ɔ�Z����+1���@�N���e�B�J��+1(+10�����܂œK�p)
        if (name.equals("�E�ӂ̃L�[�����N")) {
            if (enchant >= 10) {
            op2.ailment[HIT_SECRET] += 4;                                       //��Z����+4
            op2.CRI_MAGIC += 4;                                                 //���@�N���e�B�J��+4
            } else if (enchant >= 9) {
            op2.ailment[HIT_SECRET] += 3;                                       //��Z����+3
            op2.CRI_MAGIC += 3;                                                 //���@�N���e�B�J��+3
            } else if (enchant >= 8) {
            op2.ailment[HIT_SECRET] += 2;                                       //��Z����+2
            op2.CRI_MAGIC += 2;                                                 //���@�N���e�B�J��+2
            } else if (enchant >= 7) {
            op2.ailment[HIT_SECRET] += 1;                                       //��Z����+1
            op2.CRI_MAGIC += 1;                                                 //���@�N���e�B�J��+1
            }
        }

        //�w�����̃X�s�A�[                                                       +7���狰�|����+1 +8����PVP�_���[�W+1(+10�����܂œK�p)
        if (name.equals("�w�����̃X�s�A�[")) {
            if (enchant >= 10) {
            op2.ailment[HIT_TERROR] += 4;                                       //���|����+4
            op2.CRI_MAGIC += 3;                                                 //PVP�_���[�W+3
            } else if (enchant >= 9) {
            op2.ailment[HIT_TERROR] += 3;                                       //���|����+3
            op2.CRI_MAGIC += 2;                                                 //PVP�_���[�W+2
            } else if (enchant >= 8) {
            op2.ailment[HIT_TERROR] += 2;                                       //���|����+2
            op2.CRI_MAGIC += 1;                                                 //PVP�_���[�W+1
            } else if (enchant >= 7) {
            op2.ailment[HIT_TERROR] += 1;                                       //���|����+1
            }
        }

        //���@���J�X�̃\�[�h                                                     +8�ȍ~����1���ɋZ�p/����/���|����+1(�ő�+3)(+10�����܂œK�p)
        if (name.equals("���@���J�X�̃\�[�h") || name.equals("���@���J�X�̃\�[�h(���@���J�X�̍�����)")) {
            if (enchant >= 10) {
            op2.ailment[HIT_STUN] += 3;                                         //�Z�p����+3
            op2.ailment[HIT_SPIRIT] += 3;                                       //���얽��+3
            op2.ailment[HIT_TERROR] += 3;                                       //���|����+3
            } else if (enchant >= 9) {
            op2.ailment[HIT_STUN] += 2;                                         //�Z�p����+2
            op2.ailment[HIT_SPIRIT] += 2;                                       //���얽��+2
            op2.ailment[HIT_TERROR] += 2;                                       //���|����+2
            } else if (enchant >= 8) {
            op2.ailment[HIT_STUN] += 1;                                         //�Z�p����+1
            op2.ailment[HIT_SPIRIT] += 1;                                       //���얽��+1
            op2.ailment[HIT_TERROR] += 1;                                       //���|����+1
            }
        }

        //���@���J�X�̗��茕                                                     +8�ȍ~����1���ɋZ�p����+1(�ő�+3)(+10�����܂œK�p)
        if (name.equals("���@���J�X�̗��茕") || name.equals("���@���J�X�̗��茕(���@���J�X�̍�����)")) {
            if (enchant >= 10) {
            op2.ailment[HIT_STUN] += 3;                                         //�Z�p����+3
            } else if (enchant >= 9) {
            op2.ailment[HIT_STUN] += 2;                                         //�Z�p����+2
            } else if (enchant >= 8) {
            op2.ailment[HIT_STUN] += 1;                                         //�Z�p����+1
            }
        }

        //�p�v���I���̃����O�{�E                                                 +8�ȍ~����1���ɐ��얽��+1/�_���[�W���_�N�V��������+1(�ő�+3)(+10�����܂œK�p)
        if (name.equals("�p�v���I���̃����O�{�E") || name.equals("�p�v���I���̃����O�{�E(�p�v���I���̍�����)")) {
            if (enchant >= 10) {
            op2.ailment[HIT_SPIRIT] += 3;                                       //���얽��+3
            op2.DR_IGNORED += 3;                                                //�_���[�W���_�N�V��������+3
            } else if (enchant >= 9) {
            op2.ailment[HIT_SPIRIT] += 2;                                       //���얽��+2
            op2.DR_IGNORED += 2;                                                //�_���[�W���_�N�V��������+2
            } else if (enchant >= 8) {
            op2.ailment[HIT_SPIRIT] += 1;                                       //���얽��+1
            op2.DR_IGNORED += 1;                                                //�_���[�W���_�N�V��������+1
            }
        }

        //�p�v���I���̃f���A���u���[�h                                            +8�ȍ~����1���ɐ��얽��+1(�ő�+3)(+10�����܂œK�p)
        //�_�u���q�b�g�����m�������͖�����
        if (name.equals("�p�v���I���̃f���A���u���[�h") || name.equals("�p�v���I���̃f���A���u���[�h(�p�v���I���̍�����)")) {
            if (enchant >= 10) {
            op2.ailment[HIT_SPIRIT] += 3;                                       //���얽��+3
                                                                                //�_�u���q�b�g�����m������+3
            } else if (enchant >= 9) {
            op2.ailment[HIT_SPIRIT] += 2;                                       //���얽��+2
                                                                                //�_�u���q�b�g�����m������+2
            } else if (enchant >= 8) {
            op2.ailment[HIT_SPIRIT] += 1;                                       //���얽��+1
                                                                                //�_�u���q�b�g�����m������+1
            }
        }

        //�A���^���X�̃A�b�N�X                                                   +8�ȍ~����1���ɋ��|����+1(�ő�+3)(+10�����܂œK�p)
        if (name.equals("�A���^���X�̃A�b�N�X") || name.equals("�A���^���X�̃A�b�N�X(�A���^���X�̍�����)")) {
            if (enchant >= 10) {
            op2.ailment[HIT_TERROR] += 3;                                       //���|����+3
            } else if (enchant >= 9) {
            op2.ailment[HIT_TERROR] += 2;                                       //���|����+2
            } else if (enchant >= 8) {
            op2.ailment[HIT_TERROR] += 1;                                       //���|����+1
            }
        }

        //�A���^���X�̃X�^�b�t                                                   +8�ȍ~����1����SP+1/���@����+1(�ő�+3)(+10�����܂œK�p)
        if (name.equals("�A���^���X�̃X�^�b�t") || name.equals("�A���^���X�̃X�^�b�t(�A���^���X�̍�����)")) {
            if (enchant >= 10) {
            op2.SP                  += 3;                                       //SP+3
            op2.HIT_MAGIC           += 3;                                       //���@����+3
            } else if (enchant >= 9) {
            op2.SP                  += 2;                                       //SP+2
            op2.HIT_MAGIC           += 2;                                       //���@����+2
            } else if (enchant >= 8) {
            op2.SP                  += 1;                                       //SP+1
            op2.HIT_MAGIC           += 1;                                       //���@����+1
            }
        }

        //�����h�r�I���̃`�F�[���\�[�h                                            +8�ȍ~����1���ɔ�Z����+1(�ő�+3)(+10�����܂œK�p)
        //��_�I�o�m�������͖�����
        if (name.equals("�����h�r�I���̃`�F�[���\�[�h") || name.equals("�����h�r�I���̃`�F�[���\�[�h(�����h�r�I���̍�����)")) {
            if (enchant >= 10) {
            op2.ailment[HIT_SECRET] += 3;                                       //��Z����+3
                                                                                //��_�I�o�m������+3
            } else if (enchant >= 9) {
            op2.ailment[HIT_SECRET] += 2;                                       //��Z����+2
                                                                                //��_�I�o�m������+2
            } else if (enchant >= 8) {
            op2.ailment[HIT_SECRET] += 1;                                       //��Z����+1
                                                                                //��_�I�o�m������+1
            }
        }

        //�����h�r�I���̃L�[�����N                                               +8�ȍ~����1����SP+1/��Z����+1(�ő�+3)(+10�����܂œK�p)
        if (name.equals("�����h�r�I���̃L�[�����N") || name.equals("�����h�r�I���̃L�[�����N(�����h�r�I���̍�����)")) {
            if (enchant >= 10) {
            op2.SP                  += 3;                                       //SP+3
            op2.ailment[HIT_SECRET] += 3;                                       //��Z����+3
            } else if (enchant >= 9) {
            op2.SP                  += 2;                                       //SP+2
            op2.ailment[HIT_SECRET] += 2;                                       //��Z����+2
            } else if (enchant >= 8) {
            op2.SP                  += 1;                                       //SP+1
            op2.ailment[HIT_SECRET] += 1;                                       //��Z����+1
            }
        }

        //�^�����̎��s��                                                         +1��������[�ߋ����ǉ��_���[�W+2(��������+1)][�ߋ����N���e�B�J��+1][�Z�p����+1]����
        if (name.equals("�^�����̎��s��")) {
            if (enchant >= 0) {
            op2.DMG_SHORT += enchant;                                           //�ߋ����ǉ��_���[�W
            op2.CRI_SHORT += enchant;                                           //�ߋ����N���e�B�J��
            op2.ailment[HIT_STUN] += enchant;                                   //�Z�p����
            }
        }

        //�E�B���h�u���[�h�\�[�h                                                 +1��������[�ߋ����ǉ��_���[�W+2(��������+1)]����
        if (name.equals("�E�B���h�u���[�h�\�[�h")) {
            if (enchant >= 0) {
            op2.DMG_SHORT += enchant;                                           //�ߋ����ǉ��_���[�W
            }
        } 

        //���b�h�V���h�E�f���A���u���[�h                                          +1��������[�ߋ����ǉ��_���[�W+2(��������+1)][���얽��+1]����
        if (name.equals("���b�h�V���h�E�f���A���u���[�h")) {
            if (enchant >= 0) {
            op2.DMG_SHORT += enchant;                                           //�ߋ����ǉ��_���[�W
            op2.ailment[HIT_SPIRIT] += enchant;                                 //���얽��
            }
        }

        //�z�[���[�w�h�����X�^�b�t                                                +1��������[�ߋ����ǉ��_���[�W+2(��������+1)][SP+1][���@����+1]����
        if (name.equals("�z�[���[�w�h�����X�^�b�t")) {
            if (enchant >= 0) {
            op2.DMG_SHORT += enchant;                                           //�ߋ����ǉ��_���[�W
            op2.SP += enchant;                                                  //SP
            op2.HIT_MAGIC += enchant;                                           //���@����
            }
        }

        //�N���m�X�̋��|                                                         +1��������[�ߋ����ǉ��_���[�W+2(��������+1)][�ߋ����N���e�B�J��+1%][��Z����+1]����
        if (name.equals("�N���m�X�̋��|")) {
            if (enchant >= 0) {
            op2.DMG_SHORT += enchant;                                           //�ߋ����ǉ��_���[�W
            op2.CRI_SHORT += enchant;                                           //�ߋ����N���e�B�J��
            op2.ailment[HIT_SECRET] += enchant;                                 //��Z����
            }
        }

        //�q���y���I���̐�]                                                     +1��������[�ߋ����ǉ��_���[�W+2(��������+1)][SP][���@�N���e�B�J��+1%][��Z����+1]����
        if (name.equals("�q���y���I���̐�]")) {
            if (enchant >= 0) {
            op2.DMG_SHORT += enchant;                                           //�ߋ����ǉ��_���[�W
            op2.SP += enchant;                                                  //SP
            op2.CRI_MAGIC += enchant;                                           //���@�N���e�B�J��
            op2.ailment[HIT_SECRET] += enchant;                                 //��Z����
            }
        }

        //�^�C�^���̕��{                                                         +1��������[�ߋ����ǉ��_���[�W+2(��������+1)][�ߋ����N���e�B�J��+1%][���|����+1]����
        if (name.equals("�^�C�^���̕��{")) {
            if (enchant >= 0) {
            op2.DMG_SHORT += enchant;                                           //�ߋ����ǉ��_���[�W
            op2.CRI_SHORT += enchant;                                           //�ߋ����N���e�B�J��
            op2.ailment[HIT_TERROR] += enchant;                                 //���|����
            }
        }

        //�K�C�A�̌��{                                                           +1��������[�������ǉ��_���[�W+2(��������+1)][�������N���e�B�J��+1%][�_���[�W�ቺ����][���얽��+1]����
        if (name.equals("�K�C�A�̌��{")) {
            if (enchant >= 0) {
            op2.DMG_LONG += enchant;                                            //�������ǉ��_���[�W
            op2.CRI_LONG += enchant;                                            //�������N���e�B�J��
            op2.DR_IGNORED += enchant;                                          //�_���[�W�ቺ����
            op2.ailment[HIT_SPIRIT] += enchant;                                 //���얽��
            }
        }

        //���_�̌�                                                               +1��������[�ߋ����ǉ��_���[�W+2(��������+1)][�ߋ����N���e�B�J��+1%][�Z�p����+1][���얽��+1][���|����+1]����
        if (name.equals("���_�̌�") || name.equals("���_�̌�(�E�F�|���A�^�b�N����)")) {
            if (enchant >= 0) {
            op2.DMG_SHORT += enchant;                                           //�ߋ����ǉ��_���[�W
            op2.CRI_SHORT += enchant;                                           //�ߋ����N���e�B�J��
            op2.ailment[HIT_STUN] += enchant;                                   //�Z�p����
            op2.ailment[HIT_SPIRIT] += enchant;                                 //���얽��
            op2.ailment[HIT_TERROR] += enchant;                                 //���|����
            }
        }

        //�x�z�҂̏��Y                                                           +1��������[�ߋ����ǉ��_���[�W+2(��������+1)][�ߋ����N���e�B�J��+1%][���|����+1]����
        if (name.equals("�x�z�҂̏��Y") || name.equals("�x�z�҂̏��Y(�x�z�҂̏��Y����)")) {
            if (enchant >= 0) {
            op2.DMG_SHORT += enchant;                                           //�ߋ����ǉ��_���[�W
            op2.CRI_SHORT += enchant;                                           //�ߋ����N���e�B�J��
            op2.ailment[HIT_TERROR] += enchant;                                 //���|����
            }
        }

        //�A�C���n�U�[�h�̑M��                                                   +1��������[����_���[�W�C�~���[������+5][�ߋ����ǉ��_���[�W+2(��������+1)][�ߋ����N���e�B�J��+2%][�Z�p����+1][���얽��+1][���|����+1]����
        //�A�C���n�U�[�h�̑M��(�΃����X�^�[�͈͖��@)�ƃA�C���n�U�[�h�̈ꌂ(�ΐl���@+2�b�z�[���h)�͖����� INT&SP�ɖ��@�_���[�W�͈ˑ����Ȃ�
        if (name.equals("�A�C���n�U�[�h�̑M��")) {
            if (enchant >= 0) {
                                                                                //�C�~���[����������_���[�W+5x������(������)
            op2.DMG_SHORT += enchant;                                           //�ߋ����ǉ��_���[�W
            op2.CRI_SHORT += (enchant*2);                                       //�ߋ����N���e�B�J��+2x������
            op2.ailment[HIT_STUN] += enchant;                                   //�Z�p����
            op2.ailment[HIT_SPIRIT] += enchant;                                 //���얽��
            op2.ailment[HIT_TERROR] += enchant;                                 //���|����
            }
        }

        //�O�����J�C���̐R��                                                     +1��������[����_���[�W�C�~���[������+5][�ߋ����ǉ��_���[�W+2(��������+1)][�ߋ����N���e�B�J��+2%][�Z�p����+1]����
        //�O�����J�C���̙��K(�΃����X�^�[�͈͖��@)�ƃO�����J�C���̐R��(�ΐl���@+2�b�z�[���h)�͖����� INT&SP�ɖ��@�_���[�W�͈ˑ����Ȃ�
        if (name.equals("�O�����J�C���̐R��")) {
            if (enchant >= 0) {
                                                                                //�C�~���[����������_���[�W+5x������(������)
            op2.DMG_SHORT += enchant;                                           //�ߋ����ǉ��_���[�W
            op2.CRI_SHORT += (enchant*2);                                       //�ߋ����N���e�B�J��+2x������
            op2.ailment[HIT_STUN] += enchant;                                   //�Z�p����
            }
        }

        //����+10�ȏ�̓G���`�����g�ɂ��ǉ��_���[�W��+2(���������ɒǉ���+1)
        if (enchant >= 10) {
            op2.DMG_SHORT += enchant - 9;                                       //�ߋ����ǉ��_���[�W
            op2.DMG_LONG += enchant - 9;                                        //�������ǉ��_���[�W
        //    op2.DMG_MAGIC += enchant - 9;                                     //���@�ǉ��_���[�W
        }
    }
}
